function traerInformacionCat() {
    $.ajax(
            {
                url: "http://localhost:8080/api/Category/all",
                type: "GET",
                datatype: "JSON",
                success: function (respuesta) {
                    verRespuestaCat(respuesta);
                }
            }
    );
}

function verRespuestaCat(items) {

    $("#resultadoCat").empty();

    let myTable = "<table>";
    myTable += "<tr><th>Id</th><th>Nombre</th><th>Descripción</th><tr>";

    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        myTable += "<td><button onclick='editarInformacionCat(" + items[i].id + ")'>Editar</button>";
        myTable += "<td><button onclick='borrarElementoCat(" + items[i].id + ")'>Borrar</button>";
        myTable += "</tr>";
    }

    myTable += "</table>";
    $("#resultadoCat").append(myTable);
}

function guardarInformacionCat() {

    $("#resultadoCat").empty();

    if ($("#idCategoria").val() === "") {
        let myData = {name: $("#nameCat").val(), description: $("#descriptionCat").val()};
        let dataToSend = JSON.stringify(myData);

        $.ajax(
                {
                    url: "http://localhost:8080/api/Category/save",
                    type: "POST",
                    data: dataToSend,
                    datatype: "JSON",
                    contentType: "application/json",
                    success: function (respuesta) {
                        alert("Insercion exitosa");
                        $("#nameCat").val('');
                        $("#descriptionCat").val('');
                    },
                    error: function (xhr, status) {
                        alert("Operacion no satisfactoria", +xhr.status);
                    }
                }
        );
    } else {
        let myData = {id: $("#idCategoria").val(), name: $("#nameCat").val(), description: $("#descriptionCat").val()};
        let dataToSend = JSON.stringify(myData);

        $.ajax(
                {
                    url: "http://localhost:8080/api/Category/update",
                    type: "PUT",
                    data: dataToSend,
                    datatype: "JSON",
                    contentType: "application/json",
                    success: function (respuesta) {
                        alert("Actualizacion exitosa");
                        $("#idCategoria").val('');
                        $("#nameCat").val('');
                        $("#descriptionCat").val(''); 
                    },
                    error: function (xhr, status) {
                        alert("Operacion no satisfactoria", +xhr.status);
                    }
                }
        );
    }

}

function editarInformacionCat(idElemento) {


    $.ajax(
            {
                url: "http://localhost:8080/api/Category/" + idElemento,
                type: "GET",
                datatype: "JSON",
                success: function (respuesta) {
                    $("#idCategoria").val(idElemento);
                    $("#nameCat").val(respuesta.name);
                    $("#descriptionCat").val(respuesta.description);
                }
            }
    );

}

function borrarElementoCat(idElemento) {

    let myData = {id: idElemento};
    let dataToSend = JSON.stringify(myData);

    $.ajax(
            {
                url: "http://localhost:8080/api/Category/" + idElemento,
                type: "DELETE",
                data: dataToSend,
                datatype: "JSON",
                contentType: "application/json",
                success: function (respuesta) {
                    alert("Borrado exitoso");
                    traerInformacionCat();
                },
                error: function (xhr, status) {
                    alert("Operacion no satisfactoria", +xhr.status);
                }
            }
    );

}

