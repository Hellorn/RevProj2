export class restaurant{

    
    rid:number;
    name:string;
    username:string;
    password:string;
    address:string;
    cuisine:string;

    constructor(rid:number,name:string,username:string,password:string,cuisine:string,address:string){
        this.rid = rid;
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.cuisine = cuisine;
    }

}