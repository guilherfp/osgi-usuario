package br.com.pcsist.wta.usuario.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author guilherme.pacheco
 */
public class Activator implements BundleActivator {

  @Override
  public void start(BundleContext context) {
    System.out.println("Starting the bundle Usuário Service");
  }

  @Override
  public void stop(BundleContext context) {
    System.out.println("Stopping the bundle Usuário Service");
  }

}
