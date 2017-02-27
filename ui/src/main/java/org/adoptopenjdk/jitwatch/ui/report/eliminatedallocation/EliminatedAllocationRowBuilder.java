/*
 * Copyright (c) 2013-2016 Chris Newland.
 * Licensed under https://github.com/AdoptOpenJDK/jitwatch/blob/master/LICENSE-BSD
 * Instructions: https://github.com/AdoptOpenJDK/jitwatch/wiki
 */
package org.adoptopenjdk.jitwatch.ui.report.eliminatedallocation;

import org.adoptopenjdk.jitwatch.report.Report;
import org.adoptopenjdk.jitwatch.ui.report.IReportRowBean;
import org.adoptopenjdk.jitwatch.ui.report.cell.LinkedBCICell;
import org.adoptopenjdk.jitwatch.ui.report.cell.TextTableCell;

import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public final class EliminatedAllocationRowBuilder
{
	private EliminatedAllocationRowBuilder()
	{
	}

	public static TableView<IReportRowBean> buildTableSuggestion(ObservableList<IReportRowBean> rows)
	{
		TableView<IReportRowBean> tv = new TableView<>();

		TableColumn<IReportRowBean, String> metaClass = new TableColumn<IReportRowBean, String>("Class");
		metaClass.setCellValueFactory(new PropertyValueFactory<IReportRowBean, String>("metaClass"));
		metaClass.setCellFactory(new Callback<TableColumn<IReportRowBean, String>, TableCell<IReportRowBean, String>>()
		{
			@Override
			public TableCell<IReportRowBean, String> call(TableColumn<IReportRowBean, String> col)
			{
				return new TextTableCell();
			}
		});

		TableColumn<IReportRowBean, String> member = new TableColumn<IReportRowBean, String>("Member");
		member.setCellValueFactory(new PropertyValueFactory<IReportRowBean, String>("member"));
		member.setCellFactory(new Callback<TableColumn<IReportRowBean, String>, TableCell<IReportRowBean, String>>()
		{
			@Override
			public TableCell<IReportRowBean, String> call(TableColumn<IReportRowBean, String> col)
			{
				return new TextTableCell();
			}
		});

		TableColumn<IReportRowBean, String> compilation = new TableColumn<IReportRowBean, String>("Compilation");
		compilation.setCellValueFactory(new PropertyValueFactory<IReportRowBean, String>("compilation"));
		compilation.setCellFactory(new Callback<TableColumn<IReportRowBean, String>, TableCell<IReportRowBean, String>>()
		{
			@Override
			public TableCell<IReportRowBean, String> call(TableColumn<IReportRowBean, String> col)
			{
				return new TextTableCell();
			}
		});

		TableColumn<IReportRowBean, Report> viewBCI = new TableColumn<IReportRowBean, Report>("BCI");
		viewBCI.setCellValueFactory(new PropertyValueFactory<IReportRowBean, Report>("report"));
		viewBCI.setCellFactory(new Callback<TableColumn<IReportRowBean, Report>, TableCell<IReportRowBean, Report>>()
		{
			@Override
			public TableCell<IReportRowBean, Report> call(TableColumn<IReportRowBean, Report> col)
			{
				return new LinkedBCICell();
			}
		});
		
		TableColumn<IReportRowBean, String> directOrInline = new TableColumn<IReportRowBean, String>("How");
		directOrInline.setCellValueFactory(new PropertyValueFactory<IReportRowBean, String>("kind"));
		directOrInline.setCellFactory(new Callback<TableColumn<IReportRowBean, String>, TableCell<IReportRowBean, String>>()
		{
			@Override
			public TableCell<IReportRowBean, String> call(TableColumn<IReportRowBean, String> col)
			{
				return new TextTableCell();
			}
		});

		TableColumn<IReportRowBean, String> eliminatedType = new TableColumn<IReportRowBean, String>("Eliminated Type");
		eliminatedType.setCellValueFactory(new PropertyValueFactory<IReportRowBean, String>("eliminatedType"));
		eliminatedType.setCellFactory(new Callback<TableColumn<IReportRowBean, String>, TableCell<IReportRowBean, String>>()
		{
			@Override
			public TableCell<IReportRowBean, String> call(TableColumn<IReportRowBean, String> col)
			{
				return new TextTableCell();
			}
		});

		metaClass.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));
		member.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));
		compilation.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));
		viewBCI.prefWidthProperty().bind(tv.widthProperty().multiply(0.12));
		directOrInline.prefWidthProperty().bind(tv.widthProperty().multiply(0.1));
		eliminatedType.prefWidthProperty().bind(tv.widthProperty().multiply(0.18));

		tv.getColumns().add(metaClass);
		tv.getColumns().add(member);
		tv.getColumns().add(compilation);
		tv.getColumns().add(viewBCI);
		tv.getColumns().add(directOrInline);
		tv.getColumns().add(eliminatedType);

		tv.setItems(rows);

		return tv;
	}
}