import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';


export class Friend {
  constructor(
    public idProduit: number,
    public name: string,
    public description: string,
    public prix: number,
    public prix_achat: number,
    public image: string,
    public qantite: number,
    public category,

  ) {
  }
}

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.css']
})
export class FriendComponent implements OnInit {

  closeResult: String;
  friends: Friend[];
  friend: Friend;
  editForm: FormGroup;
  private deleteId: Number;

  constructor(
    private httpClient: HttpClient,
    private modalService: NgbModal,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.getFriends();

    // reactive form
    this.editForm = this.fb.group({
      idProduit: [''],
      nameP: [''],
      description: [''],
      prix: [''],
      prix_achat: [''],
      image: [''],
      qantite: [''],
      category: ['']
    });
  }

  getFriends() {
    this.httpClient.get<any>('http://localhost:8088/allProduits').subscribe(
      response => {
        console.log(response);
        this.friends = response;
      }
    );
  }



  open(content) {
    this.modalService.open(content, {
      size: 'lg',
      ariaLabelledBy: 'modal-basic-title'
    }).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }





  onSubmit(f: NgForm) {
    const url = 'http://localhost:8088/produits';
    this.httpClient.post(url, f.value)
      .subscribe((result) => {
        this.ngOnInit(); //reload the table
      });
    this.modalService.dismissAll(); //dismiss the modal
  }


  openDetails(targetModal, friend: Friend) {
    console.log(friend);
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
    document.getElementById('name').setAttribute('value', friend.name);
    document.getElementById('description').setAttribute('value', friend.description);
    //document.getElementById('prix').setAttribute('value', friend.prix);
    //document.getElementById('prix_achat').setAttribute('value', friend.prix_achat);
    document.getElementById('image').setAttribute('value', friend.image);
    // document.getElementById('qantite').setAttribute('value', friend.qantite);
    document.getElementById('category').setAttribute('value', friend.category.name);

  }

  openEdit(targetModal, friend: Friend) {
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
    this.editForm.patchValue({
      idProduit: friend.idProduit,
      nameP: friend.name,
      description: friend.description,
      prix: friend.prix,
      prix_achat: friend.prix_achat,
      image: friend.image,
      qantite: friend.qantite,
      category: friend.category.name
    });
  }

  onSave() {
    const editURL = 'http://localhost:8088/updateProduit/' + this.editForm.value.idProduit;
    console.log(this.editForm.value);
    this.httpClient.put(editURL, this.editForm.value)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }

  openDelete(targetModal, friend: Friend) {
    this.deleteId = friend.idProduit;
    this.modalService.open(targetModal, {
      backdrop: 'static',
      size: 'lg'
    });
  }

  onDelete() {
    const deleteURL = 'http://localhost:8088/produits/' + this.deleteId;
    this.httpClient.delete(deleteURL)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }

}
