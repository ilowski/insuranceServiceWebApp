CUSTOMERS_API_URL = 'http://localhost:8080/api/customers';
POLICIES_API_URL = 'http://localhost:8080/api/policies';


var url_string = window.location.href;
var url = new URL(url_string);
var pesel = url.searchParams.get("pesel");

var modal = document.getElementById('id01');


window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

document.getElementById("deleteButton").addEventListener('click', (event) => {
    event.preventDefault();
    fetch(`${CUSTOMERS_API_URL}/remove/${pesel}`, {
        method: 'DELETE'

    })

    location.href = 'customerSearch.html';
})

fetch(`${CUSTOMERS_API_URL}/profile/${pesel}`)
    .then(response => response.json())
    .then(customer => {
        let out = '';
        let res = `${customer.policies}`;

        var rest = res.split(',');

        out += `
<tr>
<th>${customer.id}</th>
<th>${customer.firstName}</th>
<th>${customer.secondName}</th>
<th>${customer.pesel}</th>
<th>${customer.address}</th>
<th>${customer.phoneNumber}</th>
<th>${customer.additionalInformation}</th>


`
        document.getElementById("policiesRow").setAttribute("colspan", rest.length);
        for (let i = 0; i < rest.length; i++) {
            out += `<th id=${rest[i]}>${rest[i]}</th>`
        }
        out += "</tr>";
        document.getElementById('profiletablebody').innerHTML += out;
        for (let i = 0; i < rest.length; i++) {
            document.getElementById(`${rest[i]}`).setAttribute('onclick', `location.href='${POLICIES_API_URL}/${rest[i]}'`);

        }

    })


document.getElementById('editCustomerButton').addEventListener('click', (event) => {
    const form = document.getElementById('id02');
    form.style.display = 'block';
    form.
})