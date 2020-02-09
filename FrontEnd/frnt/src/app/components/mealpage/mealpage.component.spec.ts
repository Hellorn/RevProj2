import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MealpageComponent } from './mealpage.component';

describe('MealpageComponent', () => {
  let component: MealpageComponent;
  let fixture: ComponentFixture<MealpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MealpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MealpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
