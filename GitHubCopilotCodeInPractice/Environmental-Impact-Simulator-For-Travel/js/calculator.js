/**
 * Calculator - Global object for CO2 emissions calculations
 * 
 * Provides methods for:
 * - Calculating emissions for transport modes
 * - Comparing emissions across modes
 * - Converting to carbon credits
 * - Estimating carbon credit prices
 */

const Calculator = {
    /**
     * calculateEmission(distance, transportMode)
     * Calculates CO2 emissions for a given distance and transport mode
     * 
     * Formula: distance (km) * emission factor (kg CO2/km) = total CO2 (kg)
     * 
     * @param {number} distance - Distance in kilometers
     * @param {string} transportMode - Transport mode key (bicycle, car, bus, truck)
     * @returns {number} Total CO2 emission in kg, rounded to 2 decimal places
     */
    calculateEmission: function(distance, transportMode) {
        // Get emission factor from CONFIG
        const emissionFactor = CONFIG.EMISSION_FACTORS[transportMode];

        if (emissionFactor === undefined) {
            console.error(`Transport mode "${transportMode}" not found in CONFIG.EMISSION_FACTORS`);
            return 0;
        }

        // Calculate: distance * emission factor
        const totalEmission = distance * emissionFactor;

        // Return rounded to 2 decimal places
        return Math.round(totalEmission * 100) / 100;
    },

    /**
     * calculateAllModes(distance)
     * Calculates emissions for all transport modes and compares to car baseline
     * 
     * Returns array sorted by emission (lowest first)
     * Each item includes: mode, emission (kg), percentageVsCar
     * 
     * @param {number} distance - Distance in kilometers
     * @returns {Array} Array of objects with mode, emission, percentageVsCar
     */
    calculateAllModes: function(distance) {
        const results = [];

        // First, calculate car emission as baseline
        const carEmission = this.calculateEmission(distance, 'car');

        // Calculate emissions for each transport mode
        for (const mode in CONFIG.EMISSION_FACTORS) {
            if (CONFIG.EMISSION_FACTORS.hasOwnProperty(mode)) {
                const emission = this.calculateEmission(distance, mode);
                
                // Calculate percentage vs car baseline
                // Avoid division by zero
                const percentageVsCar = carEmission > 0 
                    ? Math.round((emission / carEmission) * 100 * 100) / 100 
                    : 0;

                results.push({
                    mode: mode,
                    emission: emission,
                    percentageVsCar: percentageVsCar
                });
            }
        }

        // Sort by emission (lowest first)
        results.sort((a, b) => a.emission - b.emission);

        return results;
    },

    /**
     * calculateSavings(emission, baselineEmission)
     * Calculates CO2 savings compared to a baseline emission
     * 
     * Formula:
     * - Saved (kg) = baseline - emission
     * - Percentage = (saved / baseline) * 100
     * 
     * @param {number} emission - Actual CO2 emission in kg
     * @param {number} baselineEmission - Baseline CO2 emission in kg (usually car)
     * @returns {Object} Object with savedKg and percentage (both rounded to 2 decimals)
     */
    calculateSavings: function(emission, baselineEmission) {
        // Calculate saved kg
        const savedKg = baselineEmission - emission;

        // Calculate percentage savings
        const percentage = baselineEmission > 0 
            ? Math.round((savedKg / baselineEmission) * 100 * 100) / 100 
            : 0;

        return {
            savedKg: Math.round(savedKg * 100) / 100,
            percentage: percentage
        };
    },

    /**
     * calculateCarbonCredits(emissionKg)
     * Converts CO2 emissions to carbon credits
     * 
     * Formula: emission (kg) / KG_PER_CREDIT = credits
     * 
     * @param {number} emissionKg - Total CO2 emission in kg
     * @returns {number} Number of carbon credits, rounded to 4 decimal places
     */
    calculateCarbonCredits: function(emissionKg) {
        // Divide emission by KG_PER_CREDIT constant
        const credits = emissionKg / CONFIG.CARBON_CREDIT.KG_PER_CREDIT;

        // Return rounded to 4 decimal places
        return Math.round(credits * 10000) / 10000;
    },

    /**
     * estimateCreditPrice(credits)
     * Estimates the price range for carbon credits in Brazilian Real (BRL)
     * 
     * Calculates min, max, and average prices based on market range
     * 
     * @param {number} credits - Number of carbon credits
     * @returns {Object} Object with min, max, and average prices in BRL (all rounded to 2 decimals)
     */
    estimateCreditPrice: function(credits) {
        // Get pricing constants from CONFIG
        const priceMin = CONFIG.CARBON_CREDIT.PRICE_MIN_BRL;
        const priceMax = CONFIG.CARBON_CREDIT.PRICE_MAX_BRL;

        // Calculate min price (credits * minimum price per credit)
        const minPrice = credits * priceMin;

        // Calculate max price (credits * maximum price per credit)
        const maxPrice = credits * priceMax;

        // Calculate average price
        const averagePrice = (minPrice + maxPrice) / 2;

        return {
            min: Math.round(minPrice * 100) / 100,
            max: Math.round(maxPrice * 100) / 100,
            average: Math.round(averagePrice * 100) / 100
        };
    }
};

// Export for use in other modules (if using module system)
if (typeof module !== 'undefined' && module.exports) {
    module.exports = Calculator;
}
