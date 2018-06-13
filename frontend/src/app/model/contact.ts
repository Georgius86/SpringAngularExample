export class Contact {
  public id: number;
  public firstName: string;
  public lastName: string;
  public sex: {
    name: string;
  };
  public address: {
    street: string;
    streetNo: string;
    city: {
      name: string;
      zipCode: string;
      country: {
        name: string;
      }
    }
  };
}
