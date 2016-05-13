package br.com.pcsist.wta.usuario.client.application.home;

import javax.inject.Inject;

import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import br.com.pcsist.wta.usuario.client.components.TableUsuarios;
import br.com.pcsist.wta.usuario.shared.usuario.Usuario_;
import br.com.pcsist.wta.usuario.shared.usuario.Usuarios;

/**
 * @author guilherme.pacheco
 */
class HomePageView extends ViewWithUiHandlers<HomePageUiHandlers>
    implements HomePagePresenter.MyView {

  interface Binder extends UiBinder<Widget, HomePageView> {}

  @UiField
  TableUsuarios tableUsuarios;

  private ListDataProvider<Usuario_> dataProvider;

  @Inject
  HomePageView(Binder uiBinder) {
    initWidget(uiBinder.createAndBindUi(this));
    dataProvider = new ListDataProvider<>();
    dataProvider.addDataDisplay(tableUsuarios);
  }

  @Override
  public void showUsuario(Usuarios usuarios) {
    dataProvider.getList().clear();
    dataProvider.getList().addAll(usuarios.usuario);
    dataProvider.flush();
  }

  @Override
  public void showErro(String message) {
    Notify.notify(message, NotifyType.DANGER);
  }

}
