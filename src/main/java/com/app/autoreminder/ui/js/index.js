// Define the server url
let Server_Url = "http://localhost:8080";


function getCar() {
    console.log("GET car request");

    //Make request to server to server in order to get the products
    return fetch(Server_Url + "/car", {
        mothod: 'get'
    }).then(
        function (response) {

            if (response.ok) {
                return response.json();

            }
        }).then(function (car_list) {
        console.log(car_list);

        let carListSelector = document.querySelector("#tableL");

        for (let i = 0; i < car_list.length; i++) {

            let car = car_list[i];

            console.log("car" + car);
            let tbl = document.getElementById("tableL");
            let tableRow = tbl.insertRow();
            let cell1 = tableRow.insertCell();
            let cell2 = tableRow.insertCell();
            let cell3 = tableRow.insertCell();
            let cell4 = tableRow.insertCell();
            let cell5 = tableRow.insertCell();


            cell1.innerHTML = car.name;
            cell2.innerHTML = car.model;
            cell3.innerHTML = car.year;
            cell4.innerHTML = car.email;
            cell5.innerHTML;


            let buttonCarInfo = document.createElement("button");
            buttonCarInfo.className = "btn btn-info";
            buttonCarInfo.innerHTML = "Info";

            buttonCarInfo.addEventListener('click', function (e) {
                let idCar = e.target.getAtribute("car_id");
                localStorage.setItem("prodId", idCar);
                window.open('detail.html', '_self');
            }, false);


            cell5.appendChild(buttonCarInfo);
            carListSelector.appendChild(tableRow);
        }
    })
}


$(document).ready(function () {
    getCar();

});