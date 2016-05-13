package br.com.pcsist.wta.usuario.client.application.home;

import javax.inject.Inject;

import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import br.com.pcsist.wta.usuario.client.components.TableUsuarios;
import br.com.pcsist.wta.usuario.shared.usuario.Usuarios;

/**
 * @author guilherme.pacheco
 */
class HomePageView extends ViewWithUiHandlers<HomePageUiHandlers>
    implements HomePagePresenter.MyView {

  interface Binder extends UiBinder<Widget, HomePageView> {}

  @UiField
  TableUsuarios tableUsuarios;

  @Inject
  HomePageView(Binder uiBinder) {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void showUsuario(Usuarios usuarios) {
    tableUsuarios.setRowCount(usuarios.usuario.size());
    tableUsuarios.setRowData(usuarios.usuario);
  }

  @Override
  public void showErro(String message) {
    Notify.notify(message, NotifyType.DANGER);
  }

}
