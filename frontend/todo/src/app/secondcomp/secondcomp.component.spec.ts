import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SecondcompComponent } from './secondcomp.component';

describe('SecondcompComponent', () => {
  let component: SecondcompComponent;
  let fixture: ComponentFixture<SecondcompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecondcompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecondcompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
