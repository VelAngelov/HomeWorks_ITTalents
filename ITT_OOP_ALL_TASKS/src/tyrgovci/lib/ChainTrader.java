package tyrgovci.lib;

/*
 * • Търговска верига – работи с много доставчици на дребно и на едро (не
повече от 15) и има много търговски обекти (не повече от 10). Притежава
както будки, така и магазини в моловете.
 */
class ChainTrader extends Trader{
	static final int MAX_PROVIDERS = 15;
	static final int MAX_SHOPS = 10;
	ChainTrader(String adress, double cash) {
		super(Trader.TRADERS[2], adress, cash);
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
		providers.add(provider);
		return null;
	}

	@Override
	public TradeShop addTradeShop(TradeShop tradeShop) {
		if(tradeShop == null) {
			return null;
		}
		if(shops.contains(tradeShop)) {
			return tradeShop;
		}
		if(shops.size() >= MAX_SHOPS) {
			return tradeShop;
		}
		shops.add(tradeShop);
		tradeShop.setOwner(this);
		return null;
	}
	

}
