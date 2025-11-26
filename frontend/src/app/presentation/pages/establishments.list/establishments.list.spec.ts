import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstablishmentsList } from './establishments.list';

describe('EstablishmentsList', () => {
  let component: EstablishmentsList;
  let fixture: ComponentFixture<EstablishmentsList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EstablishmentsList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstablishmentsList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
