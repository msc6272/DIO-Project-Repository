/**
 * UI - Global object for user interface utilities and rendering
 * 
 * Provides methods for:
 * - Formatting numbers and currency
 * - DOM manipulation (show/hide/scroll)
 * - Rendering calculation results
 * - Rendering comparisons and carbon credits
 * - Loading state management
 */

const UI = {
    /**
     * UTILITY METHODS
     */

    /**
     * formatNumber(number, decimals)
     * Formats a number with specified decimal places and thousand separators
     * Uses Brazilian locale (pt-BR) for formatting
     * 
     * @param {number} number - Number to format
     * @param {number} decimals - Number of decimal places (default: 2)
     * @returns {string} Formatted number string (e.g., "1.234,56")
     */
    formatNumber: function(number, decimals = 2) {
        return Number(number).toLocaleString('pt-BR', {
            minimumFractionDigits: decimals,
            maximumFractionDigits: decimals
        });
    },

    /**
     * formatCurrency(value)
     * Formats a value as Brazilian Real currency (R$)
     * 
     * @param {number} value - Value to format in BRL
     * @returns {string} Formatted currency string (e.g., "R$ 1.234,56")
     */
    formatCurrency: function(value) {
        return new Intl.NumberFormat('pt-BR', {
            style: 'currency',
            currency: 'BRL'
        }).format(value);
    },

    /**
     * showElement(elementId)
     * Shows a hidden element by removing the "hidden" class
     * 
     * @param {string} elementId - ID of the element to show
     */
    showElement: function(elementId) {
        const element = document.getElementById(elementId);
        if (element) {
            element.classList.remove('hidden');
        } else {
            console.warn(`Element with ID "${elementId}" not found`);
        }
    },

    /**
     * hideElement(elementId)
     * Hides an element by adding the "hidden" class
     * 
     * @param {string} elementId - ID of the element to hide
     */
    hideElement: function(elementId) {
        const element = document.getElementById(elementId);
        if (element) {
            element.classList.add('hidden');
        } else {
            console.warn(`Element with ID "${elementId}" not found`);
        }
    },

    /**
     * scrollToElement(elementId)
     * Smoothly scrolls to an element on the page
     * 
     * @param {string} elementId - ID of the element to scroll to
     */
    scrollToElement: function(elementId) {
        const element = document.getElementById(elementId);
        if (element) {
            element.scrollIntoView({ behavior: 'smooth', block: 'start' });
        } else {
            console.warn(`Element with ID "${elementId}" not found`);
        }
    },

    /**
     * RENDERING METHODS
     */

    /**
     * renderResults(data)
     * Renders the main calculation results
     * 
     * HTML structure:
     * - Results card layout with origin/destination, distance, emission, mode, and savings
     * - Uses BEM naming: results__card, results__card-title, etc.
     * - Color-coded by transport mode
     * 
     * @param {Object} data - Result data object
     *   {
     *     origin: string,
     *     destination: string,
     *     distance: number,
     *     emission: number,
     *     mode: string,
     *     savings: { savedKg: number, percentage: number } or null
     *   }
     * @returns {string} HTML string for results section
     */
    renderResults: function(data) {
        const modeInfo = CONFIG.TRANSPORT_MODES[data.mode] || {};
        
        let html = `
            <!-- Route Card -->
            <div class="results__card">
                <h3 class="results__card-title">📍 Rota Selecionada</h3>
                <div class="results__card-content">
                    <div class="results__route">
                        <span class="results__city">${data.origin}</span>
                        <span class="results__arrow">→</span>
                        <span class="results__city">${data.destination}</span>
                    </div>
                </div>
            </div>

            <!-- Distance Card -->
            <div class="results__card">
                <h3 class="results__card-title">📏 Distância</h3>
                <div class="results__card-content">
                    <p class="results__value">${this.formatNumber(data.distance)} km</p>
                </div>
            </div>

            <!-- Emission Card -->
            <div class="results__card">
                <h3 class="results__card-title">🍃 Emissão de CO₂</h3>
                <div class="results__card-content">
                    <p class="results__value results__value--emission">${this.formatNumber(data.emission)} kg</p>
                    <p class="results__card-subtitle">de CO₂ emitido</p>
                </div>
            </div>

            <!-- Transport Mode Card -->
            <div class="results__card">
                <h3 class="results__card-title">🚗 Modo de Transporte</h3>
                <div class="results__card-content results__card-content--mode" style="border-left: 4px solid ${modeInfo.color}">
                    <p class="results__mode-icon">${modeInfo.icon}</p>
                    <p class="results__mode-label">${modeInfo.label}</p>
                </div>
            </div>
        `;

        // Add savings card if savings data exists and mode is not car
        if (data.savings && data.mode !== 'car') {
            html += `
            <!-- Savings Card -->
            <div class="results__card results__card--savings">
                <h3 class="results__card-title">✨ Economia de CO₂</h3>
                <div class="results__card-content">
                    <p class="results__value results__value--savings">${this.formatNumber(data.savings.savedKg)} kg</p>
                    <p class="results__card-subtitle">economizados em relação ao carro</p>
                    <div class="results__savings-badge">${this.formatNumber(data.savings.percentage)}% a menos</div>
                </div>
            </div>
            `;
        }

        return html;
    },

    /**
     * renderComparison(modesArray, selectedMode)
     * Renders comparison of emissions across all transport modes
     * 
     * HTML structure:
     * - Comparison item for each transport mode
     * - Selected mode highlighted with badge
     * - Progress bar with color coding (green/yellow/orange/red)
     * - Stats showing emission and percentage vs car
     * 
     * @param {Array} modesArray - Array of mode objects from Calculator.calculateAllModes()
     * @param {string} selectedMode - The currently selected transport mode
     * @returns {string} HTML string for comparison section
     */
    renderComparison: function(modesArray, selectedMode) {
        // Find max emission for progress bar scaling
        const maxEmission = Math.max(...modesArray.map(m => m.emission));
        
        let html = '<div class="comparison__list">';

        modesArray.forEach(mode => {
            const modeInfo = CONFIG.TRANSPORT_MODES[mode.mode] || {};
            const progressPercent = (mode.emission / maxEmission) * 100;
            
            // Determine progress bar color based on percentage vs car
            let progressColor = '#10b981'; // green (0-25%)
            if (mode.percentageVsCar > 100) {
                progressColor = '#e14444'; // red (>100%)
            } else if (mode.percentageVsCar > 75) {
                progressColor = '#f59e0b'; // orange (75-100%)
            } else if (mode.percentageVsCar > 25) {
                progressColor = '#fbbf24'; // yellow (25-75%)
            }

            const isSelected = mode.mode === selectedMode;
            const selectedClass = isSelected ? 'comparison__item--selected' : '';

            html += `
            <!-- Comparison Item -->
            <div class="comparison__item ${selectedClass}">
                ${isSelected ? '<div class="comparison__badge">✓ Selecionado</div>' : ''}
                
                <!-- Header with mode info -->
                <div class="comparison__header">
                    <div class="comparison__mode-info">
                        <span class="comparison__icon">${modeInfo.icon}</span>
                        <span class="comparison__label">${modeInfo.label}</span>
                    </div>
                    <div class="comparison__stats">
                        <span class="comparison__emission">${this.formatNumber(mode.emission)} kg CO₂</span>
                        <span class="comparison__percentage">${this.formatNumber(mode.percentageVsCar)}% vs carro</span>
                    </div>
                </div>

                <!-- Progress bar -->
                <div class="comparison__progress">
                    <div 
                        class="comparison__progress-bar" 
                        style="width: ${progressPercent}%; background-color: ${progressColor};"
                    ></div>
                </div>
            </div>
            `;
        });

        // Add helpful tip
        html += `
            <div class="comparison__tip">
                <p><strong>💡 Dica:</strong> Transporte público e bicicleta são opções muito mais sustentáveis que usar carro próprio!</p>
            </div>
        </div>
        `;

        return html;
    },

    /**
     * renderCarbonCredits(creditsData)
     * Renders carbon credit information and estimated pricing
     * 
     * HTML structure:
     * - Card 1: Total credits needed (large display)
     * - Card 2: Estimated price range (min, average, max)
     * - Info box explaining carbon credits
     * - Compensate button (demo)
     * 
     * @param {Object} creditsData - Carbon credit data
     *   {
     *     credits: number,
     *     price: { min: number, max: number, average: number }
     *   }
     * @returns {string} HTML string for carbon credit section
     */
    renderCarbonCredits: function(creditsData) {
        const html = `
            <div class="carbon-credit__grid">
                <!-- Credits Card -->
                <div class="carbon-credit__card">
                    <h3 class="carbon-credit__card-title">🎫 Créditos de Carbono Necessários</h3>
                    <div class="carbon-credit__card-content">
                        <p class="carbon-credit__value">${this.formatNumber(creditsData.credits, 4)}</p>
                        <p class="carbon-credit__card-subtitle">créditos</p>
                        <p class="carbon-credit__helper">1 crédito = 1.000 kg CO₂</p>
                    </div>
                </div>

                <!-- Price Card -->
                <div class="carbon-credit__card">
                    <h3 class="carbon-credit__card-title">💰 Preço Estimado</h3>
                    <div class="carbon-credit__card-content">
                        <p class="carbon-credit__value">${this.formatCurrency(creditsData.price.average)}</p>
                        <p class="carbon-credit__price-range">
                            de ${this.formatCurrency(creditsData.price.min)} a ${this.formatCurrency(creditsData.price.max)}
                        </p>
                    </div>
                </div>
            </div>

            <!-- Info Box -->
            <div class="carbon-credit__info">
                <h4 class="carbon-credit__info-title">ℹ️ O que são Créditos de Carbono?</h4>
                <p class="carbon-credit__info-text">
                    Créditos de carbono são certificados que representam a redução ou remoção de uma tonelada (1.000 kg) de CO₂ da atmosfera. 
                    Você pode comprar créditos para compensar suas emissões e contribuir para projetos ambientais ao redor do mundo.
                </p>
            </div>

            <!-- Action Button -->
            <button class="carbon-credit__button">
                🛒 Compensar Emissões
            </button>
        `;

        return html;
    },

    /**
     * showLoading(buttonElement)
     * Shows loading state on a button element
     * Saves original text in data attribute and displays spinner
     * 
     * @param {HTMLElement} buttonElement - The button element to update
     */
    showLoading: function(buttonElement) {
        if (!buttonElement) {
            console.warn('Button element not provided');
            return;
        }

        // Save original text in data attribute
        buttonElement.dataset.originalText = buttonElement.textContent;
        
        // Disable button
        buttonElement.disabled = true;

        // Change innerHTML to show spinner and loading text
        buttonElement.innerHTML = '<span class="spinner"></span> Calculando...';
    },

    /**
     * hideLoading(buttonElement)
     * Hides loading state and restores button to normal
     * Restores original text from data attribute
     * 
     * @param {HTMLElement} buttonElement - The button element to restore
     */
    hideLoading: function(buttonElement) {
        if (!buttonElement) {
            console.warn('Button element not provided');
            return;
        }

        // Enable button
        buttonElement.disabled = false;

        // Restore original text from data attribute
        const originalText = buttonElement.dataset.originalText || 'Calcular Emissão';
        buttonElement.textContent = originalText;
    }
};

// Export for use in other modules (if using module system)
if (typeof module !== 'undefined' && module.exports) {
    module.exports = UI;
}
