function traerInformacionRes() {
    $.ajax(
            {
                url: "http://localhost:8080/api/Reservation/all",
                type: "GET",
                datatype: "JSON",
                success: function (respuesta) {
                    verRespuestaRes(respuesta);
                }
            }
    );
}

function verRespuestaRes(items) {

    $("#resultadoRes").empty();

    let myTable = "<table>";
    myTable += "<tr><th>Id</th><th>Cliente</th><th>Salón</th><th>Fecha Inicio</th><th>Fecha Fin</th><tr>";

    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idReservation + "</td>";
        myTable += "<td>" + items[i].client["name"] + "</td>";
        myTable += "<td>" + items[i].partyroom["name"] + "</td>";
        myTable += "<td>" + items[i].startDate + "</td>";
        myTable += "<td>" + items[i].devolutionDate + "</td>";
        myTable += "</tr>";
    }

    myTable += "</table>";
    $("#resultadoRes").append(myTable);
}

function guardarInformacionRes() {

    let idCliente = $("#idCli2").val();
    $.ajax(
            {
                url: "http://localhost:8080/api/Client/" + idCliente,
                type: "GET",
                datatype: "JSON",
                success: function (respuesta) {
                    if (respuesta === null) {
                        alert("Operacion no satisfactoria");
                    } else {
                        guardarInformacionRes2(respuesta);
                    }
                }
            }
    );

}

function guardarInformacionRes2(cliente) {

    let idPartyroom = $("#idRoom2").val();
    $.ajax(
            {
                url: "http://localhost:8080/api/Partyroom/" + idPartyroom,
                type: "GET",
                datatype: "JSON",
                success: function (respuesta) {
                    if (respuesta === null) {
                        alert("Operacion no satisfactoria");
                    } else {
                        guardarInformacionRes3(cliente, respuesta);
                    }
                }
            }
    );

}

function guardarInformacionRes3(cliente, partyroom) {

    $("#resultadoRes").empty();

    let myData = {partyroom: partyroom, client: cliente,
        startDate: $("#startDate").val(), devolutionDate: $("#devolutionDate").val()};
    let dataToSend = JSON.stringify(myData);

    $.ajax(
            {
                url: "http://localhost:8080/api/Reservation/save",
                type: "POST",
                data: dataToSend,
                datatype: "JSON",
                contentType: "application/json",
                success: function (respuesta) {
                    alert("Insercion exitosa");
                    $("#idCli2").val('');
                    $("#idRoom2").val('');
                    $("#startDate").val('');
                    $("#devolutionDate").val('');
                },
                error: function (xhr, status) {
                    alert("Operacion no satisfactoria", +xhr.status);
                }
            }
    );

}  