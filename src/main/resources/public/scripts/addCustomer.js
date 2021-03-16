CUSTOMERS_API_URL = 'http://localhost:8080/api/customers';
document.getElementById("addCustomer").addEventListener('click', (event) => {
    event.preventDefault();


    fetch(`${CUSTOMERS_API_URL}/add`, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            firstName: firstName.value,
            secondName: secondName.value,
            pesel: pesel.value,
            phoneNumber: phoneNumber.value,
            address: address.value,
            additionalInformation: additionalInformation.value
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
                document.getElementById("addCustomerForm").reset();
                document.getElementById("error").innerHTML = "Sukces! Dodano użytkownika";
            }
        })


});