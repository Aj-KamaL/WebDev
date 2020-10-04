import { browser, by, element, ElementFinder, $ } from 'protractor';

export class AppPage {
  public navigateToHomePage() {
    browser.get('/');
  }
  public getPageCurrentUrl() {
    return browser.getCurrentUrl();
  }
  public getPageTitle() {
    return browser.getTitle();
  }
  public getToolbarTitle(): ElementFinder {
    return element(by.css('mat-toolbar span'));
  }



}
