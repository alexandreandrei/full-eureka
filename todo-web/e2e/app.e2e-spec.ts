import { TodoWebPage } from './app.po';

describe('todo-web App', function() {
  let page: TodoWebPage;

  beforeEach(() => {
    page = new TodoWebPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
