package br.com.iluck.screenmatch;

import br.com.iluck.screenmatch.model.DadosSerie;
import br.com.iluck.screenmatch.service.ConsumirApi;
import br.com.iluck.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var api = new ConsumirApi();
		var json = api.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		ConverterDados conversor = new ConverterDados();
		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);
	}
}
