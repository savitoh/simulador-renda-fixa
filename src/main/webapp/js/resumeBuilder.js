
$('#valor-investimento').html( "R$ " + $("#range-investimento").val());
$(document).on('input', '#range-investimento', function() {
    $('#valor-investimento').html( "R$ " + $(this).val() );
});

$('#tempo-investimento').html( $("#range-duracao-investimento").val() + " MESES");
$(document).on('input', '#range-duracao-investimento', function() {
    $('#tempo-investimento').html( $(this).val() + " MESES");
});

