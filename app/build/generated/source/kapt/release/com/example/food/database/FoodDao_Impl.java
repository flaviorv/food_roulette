package com.example.food.database;

import android.database.Cursor;
import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FoodDao_Impl implements FoodDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Food> __insertionAdapterOfFood;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Food> __deletionAdapterOfFood;

  private final EntityDeletionOrUpdateAdapter<Food> __updateAdapterOfFood;

  public FoodDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFood = new EntityInsertionAdapter<Food>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `foodTable` (`prato`,`imagem`,`estabelecimento`,`contato`,`informacoes`,`id`) VALUES (?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Food value) {
        if (value.getPrato() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPrato());
        }
        final byte[] _tmp = __converters.fromBitmap(value.getImagem());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindBlob(2, _tmp);
        }
        if (value.getEstabelecimento() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEstabelecimento());
        }
        if (value.getContato() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getContato());
        }
        if (value.getInformacoes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getInformacoes());
        }
        stmt.bindLong(6, value.getId());
      }
    };
    this.__deletionAdapterOfFood = new EntityDeletionOrUpdateAdapter<Food>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `foodTable` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Food value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfFood = new EntityDeletionOrUpdateAdapter<Food>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `foodTable` SET `prato` = ?,`imagem` = ?,`estabelecimento` = ?,`contato` = ?,`informacoes` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Food value) {
        if (value.getPrato() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPrato());
        }
        final byte[] _tmp = __converters.fromBitmap(value.getImagem());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindBlob(2, _tmp);
        }
        if (value.getEstabelecimento() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEstabelecimento());
        }
        if (value.getContato() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getContato());
        }
        if (value.getInformacoes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getInformacoes());
        }
        stmt.bindLong(6, value.getId());
        stmt.bindLong(7, value.getId());
      }
    };
  }

  @Override
  public Object insert(final Food food, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFood.insert(food);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final Food food, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFood.handle(food);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Food food, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfFood.handle(food);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Food>> getAllFoods() {
    final String _sql = "Select * From foodTable order by estabelecimento ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"foodTable"}, false, new Callable<List<Food>>() {
      @Override
      public List<Food> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPrato = CursorUtil.getColumnIndexOrThrow(_cursor, "prato");
          final int _cursorIndexOfImagem = CursorUtil.getColumnIndexOrThrow(_cursor, "imagem");
          final int _cursorIndexOfEstabelecimento = CursorUtil.getColumnIndexOrThrow(_cursor, "estabelecimento");
          final int _cursorIndexOfContato = CursorUtil.getColumnIndexOrThrow(_cursor, "contato");
          final int _cursorIndexOfInformacoes = CursorUtil.getColumnIndexOrThrow(_cursor, "informacoes");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Food> _result = new ArrayList<Food>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Food _item;
            final String _tmpPrato;
            if (_cursor.isNull(_cursorIndexOfPrato)) {
              _tmpPrato = null;
            } else {
              _tmpPrato = _cursor.getString(_cursorIndexOfPrato);
            }
            final Bitmap _tmpImagem;
            final byte[] _tmp;
            if (_cursor.isNull(_cursorIndexOfImagem)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getBlob(_cursorIndexOfImagem);
            }
            _tmpImagem = __converters.toBitmap(_tmp);
            final String _tmpEstabelecimento;
            if (_cursor.isNull(_cursorIndexOfEstabelecimento)) {
              _tmpEstabelecimento = null;
            } else {
              _tmpEstabelecimento = _cursor.getString(_cursorIndexOfEstabelecimento);
            }
            final String _tmpContato;
            if (_cursor.isNull(_cursorIndexOfContato)) {
              _tmpContato = null;
            } else {
              _tmpContato = _cursor.getString(_cursorIndexOfContato);
            }
            final String _tmpInformacoes;
            if (_cursor.isNull(_cursorIndexOfInformacoes)) {
              _tmpInformacoes = null;
            } else {
              _tmpInformacoes = _cursor.getString(_cursorIndexOfInformacoes);
            }
            _item = new Food(_tmpPrato,_tmpImagem,_tmpEstabelecimento,_tmpContato,_tmpInformacoes);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
