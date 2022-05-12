import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://lcs-apibank.herokuapp.com';

@Injectable({
  providedIn: 'root'
})
export class MovimentacaoService {

  constructor(private http: HttpClient) { }
    
    list(): Observable<any> {
      return this.http.get(`${baseUrl}/movimentacoes`);
    }

    create(movimentacao:any): Observable<any> {
      return this.http.post(`${baseUrl}/movimentacoes`,movimentacao);
   }

   findByIdConta(idConta:any): Observable<any> {
    return this.http.get(`${baseUrl}/movimentacoes/conta/${idConta}`);
  }
}
