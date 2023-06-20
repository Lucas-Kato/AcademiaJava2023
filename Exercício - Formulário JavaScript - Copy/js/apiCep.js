document.addEventListener('DOMContentLoaded', function () {
    const cepInput = document.getElementById('cep');
    cepInput.addEventListener('input', consultaCep);

    async function consultaCep() {
        const cep = cepInput.value.trim();  
        const cepRegex = /^\d{5}-\d{3}$/;

        let url = `https://viacep.com.br/ws/${cep}/json/`; 

        if (!cepRegex.test(cep)) { 
            cleanFields();
            errorCep();
        } else {
            cleanError();

            try {
                let response = await fetch(url); 
                let data = await response.json(); 

                if (data.erro) {
                    cleanFields();
                    errorCep();
                } else {
                    insertDataCep(data);
                }
            } catch (error) {
                console.log('Error :', error);
                cleanFields();
                errorCep();
            }
        }
    }

    function cleanFields() { 
        const enderecoInput = document.getElementById('endereco');
        const bairroInput = document.getElementById('bairro');
        const cidadeInput = document.getElementById('cidade');
        const estadoInput = document.getElementById('estado');

        enderecoInput.value = '';
        bairroInput.value = '';
        cidadeInput.value = '';
        estadoInput.value = '';
    }

    function errorCep() { //mostra erro no campo do cep
        const cepError = document.getElementById('cep-erro');
        cepError.classList.remove('d-none');
    }

    function cleanError() {  
        const cepError = document.getElementById('cep-erro');
        cepError.classList.add('d-none');
    }

    function insertDataCep(data) {
        const enderecoInput = document.getElementById('endereco');
        const bairroInput = document.getElementById('bairro');
        const cidadeInput = document.getElementById('cidade');
        const estadoInput = document.getElementById('estado');

        enderecoInput.value = data.logradouro;
        bairroInput.value = data.bairro;
        cidadeInput.value = data.localidade;
        estadoInput.value = data.uf;
    }
});
