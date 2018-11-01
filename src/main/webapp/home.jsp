<%-- 
    Document   : index
    Created on : 30/10/2018, 17:08:15
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags.tld"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DAC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bulma.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <section class="hero is-dark is-bold">
            <div class="hero-head">
                <div class="tabs is-centered">
                    <ul>
                        <li id="album" class="is-active"><a>Albuns</a></li>
                        <li id="banda"><a>Bandas</a></li>
                        <li><a href="index.jsp">Cadastrar</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <div class="container">
            <div class="r-album block">
                <div class="tile is-ancestor">
                    <c:forEach var="album" items="${albuns}">
                        <ct:buscaBanda id="${album.banda}"/>
                        <div class="tile is-parent is-3">
                            <article class="tile is-child box">
                                <p class="title is-4">${album.nome}</p>
                                <p>${banda.nome}, ${banda.estilo}</p>
                                <p>${album.anoLancamento}</p>
                                <br>
                                <div class="columns">
                                    <div class="column has-text-centered">
                                        <a href="#modal-album-${album.id}" class="button is-success" rel="modal:open">Atualizar</a>
                                    </div>
                                    <div class="column has-text-centered">
                                        <a href="front?action=RemoverAlbum&id=${album.id}" class="button is-danger">Remover</a>
                                    </div>
                                </div>
                            </article>
                        </div>

                        <div id="modal-album-${album.id}" class="none">
                            <p class="title is-4">Atualizar ${album.nome}</p>
                            <form method="post" action="front?action=AtualizarAlbum">
                                <input type="hidden" value="${album.id}" name="id"/>
                                <div class="field">
                                    <label class="label has-text-weight-normal">Nome</label>
                                    <div class="control">
                                        <input class="input" type="text" name="nome" value="${album.nome}">
                                    </div>
                                </div>
                                <div class="field">
                                    <div class="columns">
                                        <div class="column">
                                            <label class="label has-text-weight-normal">Banda</label>
                                            <div class="control">
                                                <input class="input" type="text" name="banda" value="${banda.nome}">
                                            </div>
                                        </div>
                                        <div class="column is-4">
                                            <label class="label has-text-weight-normal">Lançamento</label>
                                            <div class="control">
                                                <input class="input" onkeyup="somenteNumeros(this);" ng-model="numero.valor" type="text" maxlength="4" name="ano" value="${album.anoLancamento}">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <input class="button is-success is-fullwidth" type="submit" value="Adicionar"/> 
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="r-banda none">
                <div class="tile is-ancestor">
                    <c:forEach var="band" items="${bandas}">
                        <div class="tile is-parent is-3">
                            <article class="tile is-child box">
                                <p>
                                    <span class="title is-4">${band.nome}</span>
                                    <br>
                                    <span class="has-text-weight-semibold">Integrantes: </span>
                                    <c:forEach var="integrante" items="${band.integrates}">
                                        ${integrante},
                                    </c:forEach>
                                    
                                </p>

                                <p><span class="has-text-weight-semibold">Estilo: </span>${band.estilo}</p>
                                <p><span class="has-text-weight-semibold">Origem: </span>${band.localDeOrigem}</p>
                            </article>
                        </div>
                    </c:forEach>
                </div>
            </div>   
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
        <script>

                                                    var tabAlbum = document.getElementById("album");
                                                    var tabBanda = document.getElementById("banda");

                                                    tabAlbum.onclick = function () {
                                                        $('#album').addClass('is-active');
                                                        $('#banda').removeClass('is-active');

                                                        $('.r-album').addClass('block').removeClass('none');
                                                        $('.r-banda').removeClass('block').addClass('none');
                                                    };

                                                    tabBanda.onclick = function () {
                                                        $('#album').removeClass('is-active');
                                                        $('#banda').addClass('is-active');

                                                        $('.r-album').removeClass('block').addClass('none');
                                                        $('.r-banda').addClass('block').removeClass('none');
                                                    };

                                                    function somenteNumeros(num) {
                                                        var er = /[^0-9.]/;
                                                        er.lastIndex = 0;
                                                        var campo = num;
                                                        if (er.test(campo.value)) {
                                                            campo.value = "";
                                                        }
                                                    }
        </script>
    </body>
</html>
