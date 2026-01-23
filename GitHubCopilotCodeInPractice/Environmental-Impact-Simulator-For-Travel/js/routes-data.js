/**
 * RoutesDB - Global object containing Brazilian routes data
 * 
 * Structure:
 * - routes: Array of route objects with origin, destination, and distanceKm
 * - Methods: getABCities(), findDistance()
 */

const RoutesDB = {
    /**
     * Array of popular Brazilian routes
     * Each route object contains:
     * - origin: string (city name with state abbreviation)
     * - destination: string (city name with state abbreviation)
     * - distanceKm: number (distance in kilometers)
     */
    routes: [
        // Southeast Region
        { origin: 'São Paulo, SP', destination: 'Rio de Janeiro, RJ', distanceKm: 430 },
        { origin: 'São Paulo, SP', destination: 'Campinas, SP', distanceKm: 95 },
        { origin: 'São Paulo, SP', destination: 'Santos, SP', distanceKm: 65 },
        { origin: 'São Paulo, SP', destination: 'Sorocaba, SP', distanceKm: 108 },
        { origin: 'Rio de Janeiro, RJ', destination: 'Niterói, RJ', distanceKm: 13 },
        { origin: 'Rio de Janeiro, RJ', destination: 'Duque de Caxias, RJ', distanceKm: 32 },
        { origin: 'Rio de Janeiro, RJ', destination: 'Angra dos Reis, RJ', distanceKm: 150 },
        { origin: 'Belo Horizonte, MG', destination: 'Ouro Preto, MG', distanceKm: 100 },
        { origin: 'Belo Horizonte, MG', destination: 'Contagem, MG', distanceKm: 35 },
        { origin: 'Belo Horizonte, MG', destination: 'Uberlândia, MG', distanceKm: 560 },

        // Center-West Region
        { origin: 'São Paulo, SP', destination: 'Brasília, DF', distanceKm: 1015 },
        { origin: 'Rio de Janeiro, RJ', destination: 'Brasília, DF', distanceKm: 1148 },
        { origin: 'Brasília, DF', destination: 'Goiânia, GO', distanceKm: 209 },
        { origin: 'Brasília, DF', destination: 'Cuiabá, MT', distanceKm: 920 },
        { origin: 'Cuiabá, MT', destination: 'Rondonópolis, MT', distanceKm: 210 },

        // Northeast Region
        { origin: 'Salvador, BA', destination: 'Feira de Santana, BA', distanceKm: 109 },
        { origin: 'Salvador, BA', destination: 'Ilhéus, BA', distanceKm: 450 },
        { origin: 'Recife, PE', destination: 'Olinda, PE', distanceKm: 8 },
        { origin: 'Recife, PE', destination: 'Caruaru, PE', distanceKm: 135 },
        { origin: 'Fortaleza, CE', destination: 'Caucaia, CE', distanceKm: 32 },
        { origin: 'Fortaleza, CE', destination: 'Juazeiro do Norte, CE', distanceKm: 470 },
        { origin: 'São Luís, MA', destination: 'Imperatriz, MA', distanceKm: 630 },

        // South Region
        { origin: 'Curitiba, PR', destination: 'Londrina, PR', distanceKm: 360 },
        { origin: 'Curitiba, PR', destination: 'Maringá, PR', distanceKm: 430 },
        { origin: 'Curitiba, PR', destination: 'Cascavel, PR', distanceKm: 690 },
        { origin: 'Rio de Janeiro, RJ', destination: 'Curitiba, PR', distanceKm: 1070 },
        { origin: 'São Paulo, SP', destination: 'Curitiba, PR', distanceKm: 400 },
        { origin: 'Porto Alegre, RS', destination: 'Novo Hamburgo, RS', distanceKm: 65 },
        { origin: 'Porto Alegre, RS', destination: 'Santa Maria, RS', distanceKm: 290 },
        { origin: 'Curitiba, PR', destination: 'Porto Alegre, RS', distanceKm: 1140 },
        { origin: 'Florianópolis, SC', destination: 'Blumenau, SC', distanceKm: 315 },

        // North Region
        { origin: 'Manaus, AM', destination: 'Parintins, AM', distanceKm: 370 },
        { origin: 'Belém, PA', destination: 'Marabá, PA', distanceKm: 400 },
        { origin: 'Boa Vista, RR', destination: 'Manaus, AM', distanceKm: 850 },
        { origin: 'Palmas, TO', destination: 'Araguaína, TO', distanceKm: 260 },

        // Additional connections
        { origin: 'Belo Horizonte, MG', destination: 'Rio de Janeiro, RJ', distanceKm: 450 },
        { origin: 'São Paulo, SP', destination: 'Belo Horizonte, MG', distanceKm: 585 },
        { origin: 'Salvador, BA', destination: 'Vitória, ES', distanceKm: 760 },
    ],

    /**
     * getAllCities()
     * Returns a sorted array of all unique cities from the routes
     * 
     * @returns {Array<string>} Sorted array of city names with state abbreviations
     */
    getAllCities: function() {
        const citiesSet = new Set();

        // Extract all unique cities from both origin and destination
        this.routes.forEach(route => {
            citiesSet.add(route.origin);
            citiesSet.add(route.destination);
        });

        // Convert Set to Array and sort alphabetically
        return Array.from(citiesSet).sort((a, b) => {
            return a.localeCompare(b, 'pt-BR');
        });
    },

    /**
     * findDistance(origin, destination)
     * Finds the distance between two cities
     * Searches in both directions and normalizes input for case-insensitive comparison
     * 
     * @param {string} origin - Origin city (with or without state)
     * @param {string} destination - Destination city (with or without state)
     * @returns {number|null} Distance in kilometers if found, null otherwise
     */
    findDistance: function(origin, destination) {
        // Normalize inputs: trim whitespace and convert to lowercase
        const normalizedOrigin = origin.trim().toLowerCase();
        const normalizedDestination = destination.trim().toLowerCase();

        // Search through routes in both directions
        for (const route of this.routes) {
            const routeOrigin = route.origin.toLowerCase();
            const routeDestination = route.destination.toLowerCase();

            // Check if route matches in forward direction
            if (routeOrigin === normalizedOrigin && routeDestination === normalizedDestination) {
                return route.distanceKm;
            }

            // Check if route matches in reverse direction
            if (routeOrigin === normalizedDestination && routeDestination === normalizedOrigin) {
                return route.distanceKm;
            }
        }

        // No route found
        return null;
    }
};

// Export for use in other modules (if using module system)
if (typeof module !== 'undefined' && module.exports) {
    module.exports = RoutesDB;
}
