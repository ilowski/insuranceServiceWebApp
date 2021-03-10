CUSTOMERS_API_URL = 'http://localhost:8080/api/customers';
POLICIES_API_URL = 'http://localhost:8080/api/policies';


fetch(`${POLICIES_API_URL}`)
    .then(response => response.json())
    .then(policies => {
        let out = '';
        policies.forEach(policy => {

            out += `
        <tr>
        <th onclick="location.href='profile.html?pesel=${policy.customer.pesel}' " >${policy.customer.pesel} </th>
        <th>${policy.customer.secondName}</th>
        <th onclick="location.href='${POLICIES_API_URL}/${policy.numberOfPolicy}' " >${policy.numberOfPolicy}</th>
        <th>${policy.typeOfPolicy}</th>
        <th>${policy.insuranceCompany}</th>
        <th>${policy.dateOfStartPolicy}</th>
        <th>${policy.dateOfEndPolicy}</th>


        </tr>`
        })
        document.getElementById('tablebody').innerHTML += out;
    })

document.getElementById('search').addEventListener('click', (event) => {
        event.preventDefault();
        let criteria = document.getElementById('criteria').value;
        let searchItem = document.getElementById('searchItem').value;
        {
            {
                fetch(`${POLICIES_API_URL}/search?criteria=${criteria}&searchItem=${searchItem}`)
                    .then(response => {
                        if (response.ok) {
                            return response.json();
                        } else {
                            throw new Error("HTTP error " + response.status);
                        }
                    })
                    .then(policy => {
                        document.getElementById('error').innerHTML = "XDD"
                        let out = '';
                        policy.forEach(policy => {

                            out = `
        <tr>
        <th onclick="location.href='profile.html?pesel=${policy.customer.pesel}' " >${policy.customer.pesel} </th>
        <th>${policy.customer.secondName}</th>
        <th onclick="location.href='${POLICIES_API_URL}/${policy.numberOfPolicy}' " >${policy.numberOfPolicy}</th>
        <th>${policy.typeOfPolicy}</th>
        <th>${policy.insuranceCompany}</th>
        <th>${policy.dateOfStartPolicy}</th>
        <th>${policy.dateOfEndPolicy}</th>
        </tr>`

                            document.getElementById("tablebody").innerHTML = out;

                        })

                            .catch(error => {
                                document.getElementById('error').innerHTML = "POPRAW DANE!"
                            })

                    })
            }

        }


    }
)





