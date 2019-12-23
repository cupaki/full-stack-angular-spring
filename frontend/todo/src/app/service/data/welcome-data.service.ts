import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


export class HelloWorldBean {
  constructor(public message : string) {}
}


@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(
    private http : HttpClient
  ) { }

  executeHelloWorldBeanService(){
    return this.http.get<HelloWorldBean>('http://localhost:8080/hello-world-bean');
    //console.log("Execute hello world bean service");
  }

  executeHelloWorldServiceWithPathVariable(name){
    // let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader()
    // console.log(basicAuthHeaderString)
    // let headers = new HttpHeaders({
    //     Authorization: basicAuthHeaderString
    // })
    // console.log({headers})

    return this.http.get<HelloWorldBean>(`http://localhost:8080/hello-world/path-variable/${name}`,
    // {headers}
    );
      //console.log("Execute hello world bean service");
  }

  // createBasicAuthenticationHttpHeader() {
  //   let username = 'cupaki'
  //   let password = '1111'
  //   let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password)
  //   return basicAuthHeaderString;
  // }

  //Access to XMLHttpRequest at 'http://localhost:8080/hello-world/path-variable/cupaki'
  // from origin 'http://localhost:4200' has been blocked by CORS policy: 
  //No 'Access-Control-Allow-Origin' header is present on the requested resource.

}
