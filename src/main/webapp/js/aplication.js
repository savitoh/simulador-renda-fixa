$(document).ready(function($) {
  $(document).on('click', '#btn-calcular', function() {
      $.ajax({
          url: 'ControllerSimulador',
          type: 'get',
          data: {
            duracaoInvestimento: $("#range-duracao-investimento").val(),
            investimentoEscolhido: $("input[name='produto-escolhido']:checked").val(),
            valorInvestido: $("#range-investimento").val()
          },
          success: function(responseText) {
              console.log(responseText);
              $('#resultado').text("RESULTADO: R$" + responseText);
          }
      });
  });
});
