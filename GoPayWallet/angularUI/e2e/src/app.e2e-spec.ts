import { AppPage } from './app.po';
import { browser, by, element, ElementFinder, $, logging } from 'protractor';

// describe('workspace-project App', () => {
//   let page: AppPage;

//   beforeEach(() => {
//     page = new AppPage();
//   });

//   it('should display welcome message', () => {
//     page.navigateTo();
//     expect(page.getTitleText()).toEqual('GoPayWallet app is running!');
//   });

//   afterEach(async () => {
//     // Assert that there are no errors emitted from the browser
//     const logs = await browser.manage().logs().get(logging.Type.BROWSER);
//     expect(logs).not.toContain(jasmine.objectContaining({
//       level: logging.Level.SEVERE,
//     } as logging.Entry));
//   });
// });

describe("Home Page", ()=>{
     let homePage = new AppPage();

     beforeAll(() => {
      homePage.navigateToHomePage();
    });
    // it('should navigate to login page', () => {
    //   expect(homePage.getPageCurrentUrl()).toContain('/login');
    // });
    // it('should navigate to register page', () => {
    //   expect(homePage.getPageCurrentUrl()).toContain('/register');
    // });
    it('should have the correct title', () => {
      expect(homePage.getPageTitle()).toBe('GoPayWallet');
    });
    it('should have toolbar with correct title', () => {
      expect(homePage.getToolbarTitle().getText()).toBe('GoPayWallet');
    });
    
  
  
  
  
  

  
});
