<!DOCTYPE html>
<html>
    <head>
        <title>DAC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bulma.css">
        <link rel="stylesheet" href="css/bulma-divider.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@7.28.11/dist/sweetalert2.min.css"/>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <section class="hero is-fullheight background"></section>
        <section class="hero is-fullheight overlay">           
            <div class="hero-body">
                <div class="container has-text-centered">
                    <div class="columns">
                        <div class="column"></div>
                        <div class="column is-3 has-vertically-aligned-content">
                            <p class="m-bottom-1">
                                <a href="#modal-banda" class="button is-primary is-inverted is-outlined is-medium" rel="modal:open">Cadastrar Banda</a>
                            </p>
                            <p>
                                <a href="#modal-album" class="button button is-primary is-inverted is-outlined is-medium" rel="modal:open">Cadastrar Album</a>
                            </p>
                        </div>
                        <div class="is-divider-vertical" data-content="OR"></div>
                        <div class="column is-3 has-vertically-aligned-content">
                            <p>
                                <a class="button is-primary is-inverted is-outlined is-medium" href="front?action=Home">Entrar</a>
                            </p> 
                        </div>
                        <div class="column"></div>
                    </div>     
                </div>
            </div>  
        </section>

        <div id="modal-album" class="none">
            <p class="title is-4">Cadastro de Album</p>
            <form method="post" action="front?action=CadastroAlbum">
                <div class="field">
                    <label class="label has-text-weight-normal">Nome</label>
                    <div class="control">
                        <input class="input" type="text" name="nome">
                    </div>
                </div>
                <div class="field">
                    <div class="columns">
                        <div class="column">
                            <label class="label has-text-weight-normal">Banda</label>
                            <div class="control">
                                <input class="input" type="text" name="banda">
                            </div>
                        </div>
                        <div class="column is-4">
                            <label class="label has-text-weight-normal">Lançamento</label>
                            <div class="control">
                                <input class="input" onkeyup="somenteNumeros(this);" ng-model="numero.valor" type="text" maxlength="4" name="ano" placeholder="Ano">
                            </div>
                        </div>
                    </div>
                </div>
                <input class="button is-success is-fullwidth" type="submit" value="Adicionar"/> 
            </form>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.28.11/dist/sweetalert2.all.min.js"></script>
        <script>
            var erro = "${param.erro}";
            if (erro === "1") {
                swal({
                    position: 'top-end',
                    type: 'error',
                    text: 'A banda informada não está cadastrada',
                    showConfirmButton: false,
                    timer: 2000
                });
            }
            if (erro === "2") {
                swal({
                    position: 'top-end',
                    type: 'error',
                    text: 'Não foi possível realizar o cadastro',
                    showConfirmButton: false,
                    timer: 2000
                });
            }
            
            var sucesso = "${param.sucesso}";
            if (sucesso === "1") {
                swal({
                    position: 'top-end',
                    type: 'success',
                    text: 'Cadastro realizado com sucesso',
                    showConfirmButton: false,
                    timer: 2000
                });
            }
            
            function somenteNumeros(num) {
                var er = /[^0-9.]/;
                er.lastIndex = 0;
                var campo = num;
                if (er.test(campo.value)) {
                    campo.value = "";
                }
            }

            $("#modal-album").click(function () {
                $(".modal-album").addClass("is-active");
            });
            $(".modal-close").click(function () {
                $(".modal").removeClass("is-active");
            });
        </script>
    </body>
</html>
