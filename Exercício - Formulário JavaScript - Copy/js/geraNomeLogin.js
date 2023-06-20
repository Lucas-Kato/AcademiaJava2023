
document.addEventListener('DOMContentLoaded', function () {
  const nomeInput = document.getElementById('nome');
  const sobrenomeInput = document.getElementById('sobrenome');
  const loginInput = document.getElementById('login');

  nomeInput.addEventListener('input', loginNome);
  sobrenomeInput.addEventListener('input', loginNome);

  function loginNome() {
    const nome = nomeInput.value.toLowerCase();
    const sobrenome = sobrenomeInput.value.toLowerCase();
    const login = `${nome}.${sobrenome}`;
    loginInput.value = login;

  }
});
