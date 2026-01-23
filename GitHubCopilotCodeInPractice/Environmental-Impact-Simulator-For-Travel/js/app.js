/**
 * app.js - Main application initialization and event handling
 * 
 * Handles:
 * - DOM initialization when page loads
 * - Form submission and validation
 * - Calculation execution
 * - Results rendering and display
 */

// Immediately invoked function expression (IIFE) to avoid global scope pollution
(function() {
    /**
     * INITIALIZATION - Runs when DOM is fully loaded
     */
    document.addEventListener('DOMContentLoaded', function() {
        console.log('🍃 Calculadora inicializada!');

        try {
            // Step 1: Populate the cities datalist for autocomplete
            CONFIG.populateDatalist();

            // Step 2: Setup automatic distance filling based on selected cities
            CONFIG.setupDistanceAutofill();

            // Step 3: Get the calculator form element
            const calculatorForm = document.getElementById('calculator-form');

            // Step 4: Add submit event listener to the form
            if (calculatorForm) {
                calculatorForm.addEventListener('submit', handleFormSubmit);
            } else {
                console.error('Calculator form element not found');
            }
        } catch (error) {
            console.error('Error during initialization:', error);
        }
    });

    /**
     * FORM SUBMIT HANDLER
     * Handles form submission, validation, and calculation execution
     */
    function handleFormSubmit(event) {
        // Prevent default form submission behavior
        event.preventDefault();

        // Step 1: Get all form values
        const originInput = document.getElementById('origin');
        const destinationInput = document.getElementById('destination');
        const distanceInput = document.getElementById('distance');
        const transportRadios = document.getElementsByName('transport');

        // Trim whitespace from inputs
        const origin = originInput.value.trim();
        const destination = destinationInput.value.trim();
        const distanceValue = parseFloat(distanceInput.value);

        // Get selected transport mode from radio buttons
        const selectedTransport = Array.from(transportRadios).find(radio => radio.checked)?.value;

        // Step 2: Validate inputs
        if (!origin || !destination || !distanceValue || !selectedTransport) {
            alert('❌ Por favor, preencha todos os campos obrigatórios.');
            return;
        }

        if (distanceValue <= 0) {
            alert('❌ A distância deve ser maior que 0 km.');
            return;
        }

        // Step 3: Get submit button and show loading state
        const submitButton = event.target.querySelector('button[type="submit"]');
        if (submitButton) {
            UI.showLoading(submitButton);
        }

        // Step 4: Hide previous results sections
        UI.hideElement('results');
        UI.hideElement('comparison');
        UI.hideElement('carbon-credit');

        // Step 5: Simulate processing with timeout (1500ms)
        setTimeout(() => {
            try {
                // === CALCULATIONS ===

                // Calculate emission for selected transport mode
                const selectedEmission = Calculator.calculateEmission(distanceValue, selectedTransport);

                // Calculate car emission as baseline for comparison
                const carEmission = Calculator.calculateEmission(distanceValue, 'car');

                // Calculate savings compared to car (only if not car mode)
                let savings = null;
                if (selectedTransport !== 'car') {
                    savings = Calculator.calculateSavings(selectedEmission, carEmission);
                }

                // Calculate emissions for all modes for comparison
                const allModesEmissions = Calculator.calculateAllModes(distanceValue);

                // Calculate carbon credits needed
                const carbonCredits = Calculator.calculateCarbonCredits(selectedEmission);

                // Calculate carbon credit pricing
                const creditPricing = Calculator.estimateCreditPrice(carbonCredits);

                // === BUILD DATA OBJECTS ===

                // Results data object
                const resultsData = {
                    origin: origin,
                    destination: destination,
                    distance: distanceValue,
                    emission: selectedEmission,
                    mode: selectedTransport,
                    savings: savings
                };

                // Carbon credits data object
                const creditsData = {
                    credits: carbonCredits,
                    price: creditPricing
                };

                // === RENDER RESULTS ===

                // Render main results
                const resultsContent = document.getElementById('results-content');
                resultsContent.innerHTML = UI.renderResults(resultsData);

                // Render comparison between all modes
                const comparisonContent = document.getElementById('comparison-content');
                comparisonContent.innerHTML = UI.renderComparison(allModesEmissions, selectedTransport);

                // Render carbon credits section
                const carbonCreditContent = document.getElementById('carbon-credit-content');
                carbonCreditContent.innerHTML = UI.renderCarbonCredits(creditsData);

                // === DISPLAY RESULTS ===

                // Show all result sections
                UI.showElement('results');
                UI.showElement('comparison');
                UI.showElement('carbon-credit');

                // Scroll to results section smoothly
                UI.scrollToElement('results');

                // Log successful calculation
                console.log('✓ Cálculo concluído com sucesso', resultsData);

            } catch (error) {
                // Error handling
                console.error('Erro durante o cálculo:', error);
                alert('❌ Ocorreu um erro ao calcular a emissão. Tente novamente.');
            } finally {
                // Always hide loading state when finished
                if (submitButton) {
                    UI.hideLoading(submitButton);
                }
            }
        }, 1500); // 1500ms delay to simulate processing
    }

})();
