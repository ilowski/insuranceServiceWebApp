CUSTOMERS_API_URL = 'http://localhost:8080/api/customers';
POLICIES_API_URL = 'http://localhost:8080/api/policies';


var url_string = window.location.href; //window.location.href
var url = new URL(url_string);
var pesel = url.searchParams.get("pesel");

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


`
document.getElementById("policiesRow").setAttribute("colspan",rest.length);
for (let i=0; i < rest.length; i++) {
    out += `<th id=${rest[i]}>${rest[i]}</th>`
}
out += "</tr>";
document.getElementById('profiletablebody').innerHTML += out;
for (let i=0; i < rest.length; i++) {
    document.getElementById(`${rest[i]}`).setAttribute('onclick',`location.href='${POLICIES_API_URL}/${rest[i]}'`);

}

})