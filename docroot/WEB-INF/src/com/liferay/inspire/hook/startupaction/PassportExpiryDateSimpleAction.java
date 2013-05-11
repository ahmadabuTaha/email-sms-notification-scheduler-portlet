package com.liferay.inspire.hook.startupaction;

import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.expando.DuplicateColumnNameException;
import com.liferay.portlet.expando.DuplicateTableNameException;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PassportExpiryDateSimpleAction extends SimpleAction {

	public PassportExpiryDateSimpleAction() {
		super();
	}

	public void run(String[] ids) throws ActionException {

		try{

			long companyId = Long.parseLong(ids[0]);
			ExpandoTable expandoTable = null;

			try{
				expandoTable = ExpandoTableLocalServiceUtil.addDefaultTable(companyId, User.class.getName());
			}
			catch(DuplicateTableNameException dtne){
				//dtne.printStackTrace();
				expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, User.class.getName());
			}

			//---- Expando Column .

			ExpandoColumn expandoColumn = null;

			long tableId = expandoTable.getTableId();
			try{
				expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(tableId, "pass-exp-date", ExpandoColumnConstants.DATE);
			}
			catch (DuplicateColumnNameException dcne) {
				expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(tableId, "pass-exp-date");
				//dcne.printStackTrace();
			}

			String emailAddress = "ataha1@Liferay.com";

			User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);

			long classNameId = expandoTable.getClassNameId();
			long columnId = expandoColumn.getColumnId();
			long classPK = user.getUserId();
			Date d = new Date();
			SimpleDateFormat sdF = new SimpleDateFormat("yyyy-MM-dd");
			String curr_date = sdF.format(d);
			ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.addValue(classNameId, tableId, columnId, classPK, curr_date);
		}
		catch(Exception e){
			//e.printStackTrace();
			_log.info(e);
		}

	}

	private static Log _log = LogFactoryUtil.getLog(PassportExpiryDateSimpleAction.class);

}