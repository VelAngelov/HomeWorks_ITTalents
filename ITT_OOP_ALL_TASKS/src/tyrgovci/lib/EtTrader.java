package tyrgovci.lib;

/*
 * • ЕТ – едноличен търговец – той оперира само с доставчици на дребно (не
повече от 5) и притежава един търговски обект. ЕТ може да притежава
бутка на улицата или сергия на пазара.
 */
class EtTrader extends Trader{
	static final int MAX_PROVIDERS = 5;
	static final int MAX_SHOPS = 1;
	
	EtTrader(String adress, double cash) {
		super(Trader.TRADERS[1], adress, cash);
	}

	@Override
	public Provider addProvider(Provider provider) {
		if(provider==null) {
			return null;
		} 
		if(providers.size() >= MAX_PROVIDERS) {
			return provider;
		}
		if(providers.contains(provider)) {
			return provider;
		}
		if(provider.getType().equals(Provider.PROVIDERS[1])) {
			return provider;
		}
		providers.add(provider);
		return null;
	}

	@Override
	public TradeShop addTradeShop(TradeShop tradeShop) {
		if(tradeShop==null) {
			return null;
		}
		if(shops.contains(tradeShop)) {
			return tradeShop;
		}
		if(shops.size() >= MAX_SHOPS) {
			return tradeShop;
		}
		if(tradeShop.getType().equals(TradeShop.SHOPS[1])) {
			return tradeShop;
		}
		shops.add(tradeShop);
		tradeShop.setOwner(this);
		return null;
	}

}
