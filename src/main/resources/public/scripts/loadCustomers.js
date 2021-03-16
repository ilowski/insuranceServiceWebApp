CUSTOMERS_API_URL = 'http://localhost:8080/api/customers';

fetch(`${CUSTOMERS_API_URL}`)
    .then(response => response.json())
    .then(customers => {
        let out = '';
        customers.forEach(customer => {

                out += `
        <tr>
        <th onclick="location.href='profile.html?pesel=${customer.pesel}' " >${customer.pesel} </th>
        <th>${customer.firstName}</th>
        <th>${customer.secondName}</th>
        </tr>
        `
            }
        )
        document.getElementById('tablebody').innerHTML += out;
    })

document.getElementById('search').addEventListener('click', (event) => {
    event.preventDefault();
    let criteria = document.getElementById('criteria').value;
    let searchItem = document.getElementById('searchItem').value;

    fetch(`${CUSTOMERS_API_URL}/search?criteria=${criteria}&searchItem=${searchItem}`)
        .then(response => response.json())
        .then(customers => {
            let out = '';
            customers.forEach(customer => {
                out += `
        <tr>
        <th onclick="location.href='profile.html?pesel=${customer.pesel}' " >${customer.pesel} </th>
      <th>${customer.firstName}</th>
      <th>${customer.secondName}</th>
        </tr>`

                document.getElementById("tablebody").innerHTML = out;
            })
        })
})

document.getElementById("findAllCustomers").addEventListener('click', (event) => {
    event.preventDefault();
    fetch(`${CUSTOMERS_API_URL}`)

        .then(response => response.json())
        .then(customers => {
            let out = '';
            customers.forEach(customer => {

                    out += `
        <tr>
        <th onclick="location.href='profile.html?pesel=${customer.pesel}' " >${customer.pesel} </th>
        <th>${customer.firstName}</th>
        <th>${customer.secondName}</th>
        </tr>
        `
                }
            )
            document.getElementById('tablebody').innerHTML = out;
        })
})