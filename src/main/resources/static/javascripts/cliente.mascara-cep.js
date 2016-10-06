var Brewer = Brewer || {};

Brewer.MascaraCep = (function() {
	
	function MascaraCep() {
		this.inputCpf = $('.js-input-cep');
	}
	
	MascaraCep.prototype.iniciar = function() {
		this.inputCpf.mask('00.000-000');
	}
	
	return MascaraCep;
	
}());

$(function() {
	var mascaraCep = new Brewer.MascaraCep();
	mascaraCep.iniciar();
});