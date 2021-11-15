package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Favorite;
import modelDao.FavoriteModel;

@Service
public class FavoriteService {
	@Autowired
	private FavoriteModel FavoriteModel;

	public List<Favorite> getAllFavorites() {
		// TODO Auto-generated method stub
		return FavoriteModel.getAllFavorites();
	}

	public boolean addFavorite(Favorite Favorite) {
		// TODO Auto-generated method stub
		return FavoriteModel.addFavorite(Favorite);
	}

	public boolean updateFavorite(Favorite Favorite) {
		// TODO Auto-generated method stub
		return FavoriteModel.updateFavorite(Favorite);
	}

	public boolean deleteFavorite(int FavoriteId) {
		// TODO Auto-generated method stub
		return FavoriteModel.deleteFavorite(FavoriteId);
	}

	public Favorite findFavoriteById(int FavoriteId) {
		// TODO Auto-generated method stub
		return FavoriteModel.findFavoriteById(FavoriteId);
	}
}

