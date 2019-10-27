package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class UsedProduct extends Product{
		
		private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		private Date manufactureDate;
		
		public UsedProduct() 
		{
			super();
		}
		
		public UsedProduct(String name, Double price, Date manufactureDate)
		{
			super(name, price);
			this.manufactureDate = manufactureDate;
		}
		
		public Date getManufactureDate()
		{
			return manufactureDate;
		}
		
		public void setManufacutureDate(Date manufactureDate)
		{
			this.manufactureDate = manufactureDate;
		}
		
		@Override
		public String priceTag()
		{
			StringBuilder sb = new StringBuilder();
			sb.append(super.getName() +" (used) ");
			sb.append("$ " +String.format("%.2f", getPrice()));
			sb.append(" (Manufacture date: ");
			sb.append(sdf.format(manufactureDate) + ")");
			
			return sb.toString();		
		}
}
