package br.com.pcsist.wta.usuario.client.application;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

/**
 * @author guilherme.pacheco
 */
class ApplicationView extends ViewWithUiHandlers<ApplicationUiHandlers>
    implements ApplicationPresenter.MyView {

  interface Binder extends UiBinder<Widget, ApplicationView> {}

  @UiField
  SimplePanel contentContainer;

  @Inject
  ApplicationView(Binder uiBinder) {
    initWidget(uiBinder.createAndBindUi(this));
    bindSlot(ApplicationPresenter.SLOT_MAIN, contentContainer);
  }

}
