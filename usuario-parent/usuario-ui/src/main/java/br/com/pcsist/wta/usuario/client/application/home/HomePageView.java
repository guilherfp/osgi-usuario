package br.com.pcsist.wta.usuario.client.application.home;

import javax.inject.Inject;

import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import br.com.pcsist.wta.usuario.shared.usuario.Usuario;
import br.com.pcsist.wta.usuario.shared.usuario.Usuarios;

class HomePageView extends ViewImpl implements HomePagePresenter.MyView {

  interface Binder extends UiBinder<Widget, HomePageView> {}

  @Inject
  HomePageView(Binder uiBinder) {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void showUsuario(Usuarios usuarios) {
    for (Usuario usuario : usuarios.getUsuario()) {
      Notify.notify(usuario.toString());
    }
  }

  @Override
  public void showErro(String message) {
    Notify.notify(message, NotifyType.DANGER);
  }

}
