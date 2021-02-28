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
                firstName: firstName.value,
                secondName: secondName.value,
                pesel: pesel.value

            }
        })
    })

        .then(response => response.text())
        .then((text) => {
            console.log(text);
        });

});

