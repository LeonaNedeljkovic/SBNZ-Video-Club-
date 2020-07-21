import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterUserComponent } from './pages/register-user/register-user.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ShowFilmsComponent } from './components/films/show-films/show-films.component';
import { SearchFilmsComponent } from './components/films/search-films/search-films.component';
import { DetailsFilmComponent } from './components/films/details-film/details-film.component';
import { RatingComponent } from './components/reviews/rating/rating.component';
import { CreateReviewComponent } from './components/reviews/create-review/create-review.component';
import { MyReviewsComponent } from './components/reviews/my-reviews/my-reviews.component';
import { OffersShowComponent } from './components/offers/offers-show/offers-show.component';
import { MessageComponent } from './pages/message/message.component';
import { AddActorComponent } from './components/actors/add-actor/add-actor.component';
import { ShowAllActorsComponent } from './components/actors/show-all-actors/show-all-actors.component';
import { UpdateArtistComponent } from './components/actors/update-artist/update-artist.component';
import { CreateFilmComponent } from './components/films/create-film/create-film.component';
import { CreateOfferComponent } from './components/offers/create-offer/create-offer.component';
import { ShowOffersAdminComponent } from './components/offers/show-offers-admin/show-offers-admin.component';
import { UpdateOfferComponent } from './components/offers/update-offer/update-offer.component';
import { ShowAllReportsComponent } from './components/reports/show-all-reports/show-all-reports.component';
import { ActionCreateComponent } from './components/actions/action-create/action-create.component';
import { ActionShowComponent } from './components/actions/action-show/action-show.component';
import { AgeFreeMinutesTemplateComponent } from './components/templates/age-free-minutes-template/age-free-minutes-template.component';
import { AgeTitleFreeMinutesTemplateComponent } from './components/templates/age-title-free-minutes-template/age-title-free-minutes-template.component';
import { TitleFreeMinutesTemplateComponent } from './components/templates/title-free-minutes-template/title-free-minutes-template.component';
import { FilmRestrictionTemplateComponent } from './components/templates/film-restriction-template/film-restriction-template.component';
import { TitleTemplateComponent } from './components/templates/title-template/title-template.component';
import { GenreRestrictionTemplateComponent } from './components/templates/genre-restriction-template/genre-restriction-template.component';
import { AgeTemplateComponent } from './components/templates/age-template/age-template.component';
import { ImmunityTemplateComponent } from './components/templates/immunity-template/immunity-template.component';
import { FilmReportComponent } from './components/films/film-report/film-report.component';




const routes: Routes = [
 {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'rating',
    component: RatingComponent,
  },
  {
    path: 'review',
    component: CreateReviewComponent,
  },
  {
    path: 'registerUser',
    component: RegisterUserComponent,
  },
  {
    path: 'message',
    component: MessageComponent,
  },
  { 
    path: 'create-offer',
    component: CreateOfferComponent
  },
  { 
    path: 'update-offer',
    component:UpdateOfferComponent
  },
  { 
    path: 'add-actor',
     component: AddActorComponent
  },
  { 
    path: 'update-artist',
    component: UpdateArtistComponent
  },
  { 
    path: 'age-template',
    component: AgeTemplateComponent
  },
  { 
    path: 'age-free-minutes-template',
    component: AgeFreeMinutesTemplateComponent
  },
  { 
    path: 'age-title-free-minutes-template',
    component: AgeTitleFreeMinutesTemplateComponent
  },
  { 
    path: 'title-free-minutes-template',
    component: TitleFreeMinutesTemplateComponent
  },
  { 
    path: 'film-restriction-template',
    component: FilmRestrictionTemplateComponent
  },
  { 
    path: 'genre-restriction-template',
    component: GenreRestrictionTemplateComponent
  },
  { 
    path: 'title-template',
    component: TitleTemplateComponent
  },
  { 
    path: 'immunity-template',
    component: ImmunityTemplateComponent
  },
  { 
    path: 'film-report',
    component: FilmReportComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    children: [
      { path: 'films-show', component: ShowFilmsComponent },
      { path: 'films-search', component: SearchFilmsComponent },
      { path: 'film-details', component: DetailsFilmComponent },
      { path: 'reviews', component: MyReviewsComponent },
      { path: 'offers', component: OffersShowComponent },
      { path: 'show-all-actors',component:ShowAllActorsComponent},
      { path: 'create-film', component:CreateFilmComponent},
      { path: 'show-all-offers', component:ShowOffersAdminComponent},
      { path: 'reports', component:ShowAllReportsComponent},
      { path: 'action-create', component: ActionCreateComponent },
      { path: 'action-show', component: ActionShowComponent }
    ] 
  },

  {path: '**', redirectTo: 'dashboard/films-show'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }