package controllers

import play.api._
import play.api.mvc._
import javax.inject.Inject
import com.mohiva.play.silhouette.api.{ Environment, LogoutEvent, Silhouette }
import com.mohiva.play.silhouette.impl.authenticators.CookieAuthenticator
import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
import models.User
import play.api.i18n.MessagesApi
import scala.concurrent.impl.Future
import scala.concurrent.Future
import forms.SignInForm

class Application @Inject() (
  val messagesApi: MessagesApi,
  val env: Environment[User, CookieAuthenticator])
  extends Silhouette[User, CookieAuthenticator] {
  
//  @Inject
//  Application ()
  

  def index = SecuredAction.async { implicit request =>
    Future.successful(Ok(views.html.index(request.identity)))
  }

  def home = SecuredAction.async { implicit request =>
    Future.successful(Ok(views.html.home("Kedar")))
  }
  
   def signIn = UserAwareAction.async { implicit request =>
    request.identity match {
      case Some(user) => Future.successful(Redirect(routes.Application.index()))
      case None => Future.successful(Ok(views.html.signIn(SignInForm.form)))
    }
  }

}
