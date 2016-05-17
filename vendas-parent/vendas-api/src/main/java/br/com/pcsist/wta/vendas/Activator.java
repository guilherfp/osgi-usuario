package br.com.pcsist.wta.vendas;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author guilherme.pacheco
 */
public class Activator implements BundleActivator {

  @Override
  public void start(BundleContext context) {
    System.out.println("Starting the bundle Vendas API");
  }

  @Override
  public void stop(BundleContext context) {
    System.out.println("Stopping the bundle Vendas API");
  }

}
