//
//  ViewController.swift
//  lab_04
//
//  Created by Reid Pritchard on 9/29/21.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var result_label: UILabel!
    @IBOutlet weak var text_field: UITextField!
    @IBOutlet weak var stepper: UIStepper!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        let tap = UITapGestureRecognizer(target: self, action: #selector(UIInputViewController.dismissKeyboard))
        view.addGestureRecognizer(tap)
        
        update_res_label()
    }
    
    @objc func dismissKeyboard() {
        view.endEditing(true)
    }

    func update_res_label() {
        let new_val = calculate_result(text_value: text_field.text?.count ?? 0, stepper_val: stepper.value)
        print(new_val)
        result_label.text = "\(new_val)"
    }
    
    func calculate_result(text_value t_val: Int, stepper_val s_val: Double) -> Double {
        return Double(s_val * Double(t_val + 2))
    }
    
    @IBAction func stepper_changed(_ sender: Any) {
        update_res_label()
    }
    
    @IBAction func text_changed(_ sender: Any) {
        update_res_label()
    }
    
    @IBAction func text_input_done(_ sender: UITextField) {
        sender.resignFirstResponder()
    }
    
    @IBAction func show_solution(_ sender: Any) {
        let controller = UIAlertController(title: "Please Confirm", message: "Are you sure you're ready for the solution?", preferredStyle: .alert)
        let acceptAction = UIAlertAction(title: "Yes!", style: .default) { (handler) in
            self.result_label.text = "value of the stepper * length of the text + 2"
        }
        let cancelAction = UIAlertAction(title: "No not yet", style: .cancel) { (handler) in
            print("Not ready yet.")
        }
        
        controller.addAction(acceptAction)
        controller.addAction(cancelAction)
        
        self.present(controller, animated: true, completion: nil)
    }
}

