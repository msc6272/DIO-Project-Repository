/**
 * CONFIG - Global configuration object for CO2 emissions calculator
 * 
 * Contains:
 * - Emission factors for different transport modes
 * - Transport mode metadata
 * - Carbon credit pricing
 * - Utility methods for UI setup
 */

const CONFIG = {
    /**
     * EMISSION_FACTORS object
     * CO2 emissions in kg per kilometer for each transport mode
     */
    EMISSION_FACTORS: {
        bicycle: 0,
        car: 0.12,
        bus: 0.089,
        truck: 0.96
    },

    /**
     * TRANSPORT_MODES object
     * Metadata for each transport mode
     * Each mode contains: label (Portuguese), icon (emoji), color (hex)
     */
    TRANSPORT_MODES: {
        bicycle: {
            label: 'Bicicleta',
            icon: '🚴',
            color: '#3b8216'
        },
        car: {
            label: 'Carro',
            icon: '🚗',
            color: '#e14444'
        },
        bus: {
            label: 'Ônibus',
            icon: '🚌',
            color: '#10b981'
        },
        truck: {
            label: 'Caminhão',
            icon: '🚚',
            color: '#f59e0b'
        }
    },

    /**
     * CARBON_CREDIT object
     * Pricing and calculation parameters for carbon credits
     */
    CARBON_CREDIT: {
        KG_PER_CREDIT: 1000,
        PRICE_MIN_BRL: 50,
        PRICE_MAX_BRL: 150
    },

    /**
     * populateDatalist()
     * Populates the cities datalist with all available cities from RoutesDB
     * Creates option elements for each city and appends to the datalist element
     */
    populateDatalist: function() {
        // Get the datalist element
        const datalist = document.getElementById('cities-list');
        
        // Check if RoutesDB is available
        if (typeof RoutesDB === 'undefined') {
            console.error('RoutesDB is not defined. Make sure routes-data.js is loaded before config.js');
            return;
        }

        // Get all cities from RoutesDB
        const cities = RoutesDB.getAllCities();

        // Clear existing options
        datalist.innerHTML = '';

        // Create and append option elements for each city
        cities.forEach(city => {
            const option = document.createElement('option');
            option.value = city;
            datalist.appendChild(option);
        });

        console.log(`Populated datalist with ${cities.length} cities`);
    },

    /**
     * setupDistanceAutofill()
     * Sets up event listeners for automatic distance filling based on selected cities
     * Handles manual distance input toggle via checkbox
     */
    setupDistanceAutofill: function() {
        // Get form elements
        const originInput = document.getElementById('origin');
        const destinationInput = document.getElementById('destination');
        const distanceInput = document.getElementById('distance');
        const manualCheckbox = document.getElementById('manual-distance');
        const helperText = document.querySelector('.calculator-form__helper');

        // Check if all elements exist
        if (!originInput || !destinationInput || !distanceInput || !manualCheckbox || !helperText) {
            console.error('One or more form elements not found');
            return;
        }

        // Helper function to find and fill distance
        const findAndFillDistance = () => {
            const origin = originInput.value.trim();
            const destination = destinationInput.value.trim();

            // Only proceed if both fields are filled
            if (!origin || !destination) {
                distanceInput.value = '';
                helperText.textContent = 'A distância será preenchida automaticamente';
                helperText.style.color = '#6b7280';
                return;
            }

            // Find distance using RoutesDB
            const distance = RoutesDB.findDistance(origin, destination);

            if (distance !== null) {
                // Distance found - fill and lock the input
                distanceInput.value = distance;
                distanceInput.readOnly = true;
                helperText.textContent = '✓ Distância encontrada automaticamente';
                helperText.style.color = '#10b981';
            } else {
                // Distance not found - clear and suggest manual input
                distanceInput.value = '';
                distanceInput.readOnly = true;
                helperText.textContent = 'Rota não encontrada. Marque a caixa abaixo para inserir manualmente.';
                helperText.style.color = '#e14444';
            }
        };

        // Event listeners for origin and destination inputs
        originInput.addEventListener('change', findAndFillDistance);
        destinationInput.addEventListener('change', findAndFillDistance);

        // Event listener for manual distance checkbox
        manualCheckbox.addEventListener('change', (event) => {
            if (event.target.checked) {
                // When checked: unlock distance input for manual entry
                distanceInput.readOnly = false;
                distanceInput.value = '';
                helperText.textContent = 'Digite a distância em quilômetros';
                helperText.style.color = '#6b7280';
            } else {
                // When unchecked: try to find route again
                findAndFillDistance();
            }
        });

        console.log('Distance autofill setup completed');
    }
};

// Export for use in other modules (if using module system)
if (typeof module !== 'undefined' && module.exports) {
    module.exports = CONFIG;
}
