CUSTOMERS_API_URL = 'http://localhost:8080/api/customers';
POLICIES_API_URL = 'http://localhost:8080/api/policies';

fetch(`${CUSTOMERS_API_URL}`)
.then(response => response.json())
.then(customers => {
let out = '';
    customers.forEach(customer => {

        out+=`
        <tr>
        <td>${customer.firstName}</td>
        <td>${customer.secondName}</td>
        </tr>`
    })
    document.getElementById("policies").innerHTML += out;
})





fetch(`${POLICIES_API_URL}/searchTwoWeeksPolicies`)
.then(response => response.json())
.then(policies => {
let out = '';
    policies.forEach(policy=> {

        out+=`
        <tr>
        <td>${policy.numberOfPolicy}</td>
        <td>${policy.typeOfPolicy}</td>
        <td>${policy.insuranceCompany}</td>
        <td>${policy.dateOfStartPolicy}</td>
        <td>${policy.dateOfEndPolicy}</td>
        <td>${policy.customerId}</td>
        </tr>`
    })
    document.getElementById("policies").innerHTML += out;
})





