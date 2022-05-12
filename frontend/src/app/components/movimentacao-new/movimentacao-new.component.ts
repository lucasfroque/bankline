import { Component, OnInit } from '@angular/core';
import { CorrentistaService } from 'src/app/services/correntista.service';
import { MovimentacaoService } from 'src/app/services/movimentacao.service'

@Component({
  selector: 'app-movimentacao-new',
  templateUrl: './movimentacao-new.component.html',
  styleUrls: ['./movimentacao-new.component.css']
})
export class MovimentacaoNewComponent implements OnInit {
  correntistas:any;

  dataHora:any;
  tipo:any;
  valor:any;
  descricao:any;

  constructor(
    private movimentacaoService: MovimentacaoService,
    private correntistaService: CorrentistaService,
  ) { }

  ngOnInit(): void {
    this.exibirCorrentistas();
  }

  exibirCorrentistas(): void {
    this.correntistaService.list()
      .subscribe(
        data => {
          this.correntistas = data;
        },
        error => {
          console.log(error);
        });
  }

  save(): void {

    console.log(this.correntistas)

    const movimentacao:any = {
      valor:this.valor,
      descricao:this.descricao,
      tipo:this.tipo,
      idConta:this.correntistas.id,
      dataHora:this.dataHora

    };

    this.movimentacaoService.create(movimentacao)
      .subscribe(
        response => {
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

}
