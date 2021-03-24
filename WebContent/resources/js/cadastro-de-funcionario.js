var app = new Vue({
	el:"#app",
	data: {
		funcionarios: {
			nome: "",
			salario: "",
			email: "",
			idade: "",
			salario: "",
			setor: ""

		}
	},


	methods: {
		cadastrarFuncionario: function () {
			const fl = this;
			axios.post("/funcionarios/rs/funcionarios")
			.then(Response => { fl.funcionarios = Response.data})
			//this.funcionarios.push({ nome: nomeField, salario: salarioField, email: emailField, idade: idadeField, setor: setorField })
		}
	}
});





