CUSTOMERS_API_URL = 'http://localhost:8080/api/customers';
POLICIES_API_URL = 'http://localhost:8080/api/policies';


document.getElementById("addPolicy").addEventListener('click', (event) => {
    event.preventDefault();


    fetch(`${POLICIES_API_URL}/add`, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            numberOfPolicy: insuranceNumber.value,
            typeOfPolicy: typeOfPolicy.value,
            insuranceCompany: insuranceCompany.value,
            dateOfStartPolicy: dateOfStartPolicy.value,
            dateOfEndPolicy: dateOfEndPolicy.value,
            customer: {
                pesel: pesel.value
            }
        })

    })

        .then(response => {
            const contentType = response.headers.get("content-type");
            if (contentType && contentType.indexOf("application/json") !== -1) {
                return response.json()
                    .then(response => {
                        document.getElementById("error").innerHTML = `${response.fieldErrors.message}`
                    })
            } else {
                document.getElementById("addPolicyForm").reset();
                document.getElementById("error").innerHTML = "Sukces! Dodano polise";
            }
        })





});

