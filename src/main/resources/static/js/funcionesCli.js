function traerInformacionCli() {
    $.ajax(
            {
                url: "http://localhost:8080/api/Client/all",
                type: "GET",
                datatype: "JSON",
                success: function (respuesta) {
                    verRespuestaCli(respuesta);
                }
            }
    );
}

function verRespuestaCli(items) {

    $("#resultadoCli").empty();

    let myTable = "<table>";
    myTable += "<tr><th>Id</th><th>Nombre</th><th>Email</th><th>Edad</th><tr>";

    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idClient + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].age + "</td>";
        myTable += "<td><button onclick='editarInformacionCli(" + items[i].idClient + ")'>Editar</button>";
        myTable += "<td><button onclick='borrarElementoCli(" + items[i].idClient + ")'>Borrar</button>";
        myTable += "</tr>";
    }

    myTable += "</table>";
    $("#resultadoCli").append(myTable);
}

function guardarInformacionCli() {

    $("#resultadoCli").empty();
    
    if ($("#idCliente").val() === "") {
        let myData = {name: $("#nameCli").val(), email: $("#emailCli").val(),
            password: $("#passwordCli").val(), age: $("#ageCli").val()};
        let dataToSend = JSON.stringify(myData);

        $.ajax(
                {
                    url: "http://localhost:8080/api/Client/save",
                    type: "POST",
                    data: dataToSend,
                    datatype: "JSON",
                    contentType: "application/json",
                    success: function (respuesta) {
                        alert("Insercion exitosa");
                        $("#nameCli").val('');
                        $("#emailCli").val('');
                        $("#passwordCli").val('');
                        $("#ageCli").val('');
                    },
                    error: function (xhr, status) {
                        alert("Operacion no satisfactoria", +xhr.status);
                    }
                }
        );
    } else {
        let myData = {idClient: $("#idCliente").val(), email: $("#emailCli").val(), 
            password: $("#passwordCli").val(), name: $("#nameCli").val(),age: $("#ageCli").val()};
        let dataToSend = JSON.stringify(myData);

        $.ajax(
                {
                    url: "http://localhost:8080/api/Client/update",
                    type: "PUT",
                    data: dataToSend,
                    datatype: "JSON",
                    contentType: "application/json",
                    success: function (respuesta) {
                        alert("Actualizacion exitosa");
                        $("#idCliente").val('');
                        $("#nameCli").val('');
                        $("#emailCli").val('');
                        $("#passwordCli").val('');
                        $("#ageCli").val('');
                    },
                    error: function (xhr, status) {
                        alert("Operacion no satisfactoria", +xhr.status);
                    }
                }
        );
    }

}

function editarInformacionCli(idElemento) {


    $.ajax(
            {
                url: "http://localhost:8080/api/Client/" + idElemento,
                type: "GET",
                datatype: "JSON",
                success: function (respuesta) {
                    $("#idCliente").val(idElemento);
                    $("#nameCli").val(respuesta.name);
                    $("#emailCli").val(respuesta.email);
                    $("#passwordCli").val(respuesta.password);
                    $("#ageCli").val(respuesta.age);
                }
            }
    );

}

function borrarElementoCli(idElemento) {

    let myData = {id: idElemento};
    let dataToSend = JSON.stringify(myData);

    $.ajax(
            {
                url: "http://localhost:8080/api/Client/" + idElemento,
                type: "DELETE",
                data: dataToSend,
                datatype: "JSON",
                contentType: "application/json",
                success: function (respuesta) {
                    alert("Borrado exitoso");
                    traerInformacionCli();
                },
                error: function (xhr, status) {
                    alert("Operacion no satisfactoria", +xhr.status);
                }
            }
    );

}