package br.com.pcsist.wta.usuario.api;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  public void start(BundleContext context) {
    System.out.println("Starting the bundle Usuário API");
  }

  public void stop(BundleContext context) {
    System.out.println("Stopping the bundle Usuário API");
  }

}
